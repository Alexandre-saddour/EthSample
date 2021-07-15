package fr.asaddour.ethsample.data.wallet

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.web3j.crypto.WalletUtils
import java.io.File
import javax.inject.Inject

class LocalWalletDataSource @Inject constructor(
    private val appContext: Context
) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "prefs")

    fun loadEthWalletName(walletPassword: String) = runBlocking {
        appContext.dataStore.data.map { prefs -> prefs[ethWalletFileNameKey] }
            .firstOrNull()
            ?: run {
                // loading wallet returned null
                // generate wallet
                val walletPath = appContext.filesDir.absolutePath
                val walletDir = File(walletPath)
                WalletUtils.generateLightNewWalletFile(walletPassword, walletDir).also {
                    saveEthWalletName(it)
                }
            }
    }

    private fun saveEthWalletName(name: String) = runBlocking {
        appContext.dataStore.edit { prefs -> prefs[ethWalletFileNameKey] = name }
    }

    companion object {
        private val ethWalletFileNameKey = stringPreferencesKey("walletFileName")
    }
}
