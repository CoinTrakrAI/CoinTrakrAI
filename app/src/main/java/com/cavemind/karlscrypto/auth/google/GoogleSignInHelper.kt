package com.cavemind.karlscrypto.auth.google

import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.signin.*

object GoogleSignInHelper {
    fun getSignInIntent(context: Context): Intent {
        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        val client = GoogleSignIn.getClient(context, options)
        return client.signInIntent
    }

    fun getLastSignedInAccount(context: Context): GoogleSignInAccount? {
        return GoogleSignIn.getLastSignedInAccount(context)
    }
}
