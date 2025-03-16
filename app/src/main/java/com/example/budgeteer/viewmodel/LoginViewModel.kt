package com.example.budgeteer.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.budgeteer.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LoginViewModel: ViewModel() {
    private var user by mutableStateOf<User?>(null)
    private var loginError by mutableStateOf<String?>(null)
    private var isLoading by mutableStateOf(false)

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun registerUser(username: String, email: String, password: String, onResult: (Boolean) -> Unit) {
        isLoading = true
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                isLoading = false
                if (task.isSuccessful) {
                    val firebaseUser = auth.currentUser
                    firebaseUser?.let {
                        getNextUserId { newUserId ->
                            val newUser = User(userID = newUserId, username = username, email = email)
                            saveUserToFirestore(newUser, onResult)
                        }
                    }
                } else {
                    loginError = task.exception?.message
                    onResult(false)
                }
            }
    }

    fun loginUser(email: String, password: String, onResult: (Boolean) -> Unit) {
        isLoading = true
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                isLoading = false
                if (task.isSuccessful) {
                    auth.currentUser?.let { firebaseUser ->
                        fetchUserFromFirestore(firebaseUser.email ?: "", onResult)
                    }
                } else {
                    loginError = task.exception?.message
                    onResult(false)
                }
            }
    }

    fun logout() {
        auth.signOut()
        user = null
    }

    private fun getNextUserId(onResult: (Int) -> Unit) {
        db.collection("users")
            .orderBy("userId")
            .limitToLast(1)
            .get()
            .addOnSuccessListener { documents ->
                val lastUserId = if (documents.isEmpty) 0 else documents.documents.first().getLong("userId")?.toInt() ?: 0
                onResult(lastUserId + 1)
            }
            .addOnFailureListener {
                onResult(1)
            }
    }

    private fun saveUserToFirestore(user: User, onResult: (Boolean) -> Unit) {
        db.collection("users").document(user.userID.toString())
            .set(user)
            .addOnSuccessListener { onResult(true) }
            .addOnFailureListener { onResult(false) }
    }

    private fun fetchUserFromFirestore(email: String, onResult: (Boolean) -> Unit) {
        db.collection("users")
            .whereEqualTo("email", email)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    val userData = documents.documents.first().toObject(User::class.java)
                    user = userData
                    onResult(true)
                } else {
                    onResult(false)
                }
            }
            .addOnFailureListener {
                onResult(false)
            }
    }
}