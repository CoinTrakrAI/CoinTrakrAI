package com.cavemind.karlscrypto.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object FirebaseService {
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun createUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
    }

    fun saveTradeData(userId: String, tradeInfo: Map<String, Any>) {
        db.collection("trades").document(userId).set(tradeInfo)
    }
}
