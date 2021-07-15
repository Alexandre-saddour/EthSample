package fr.asaddour.ethsample.data.wallet

import android.content.Context
import fr.asaddour.ethsample.domain.wallet.WalletRepository
import java.io.File
import javax.inject.Inject

class WalletRepositoryImpl @Inject constructor(
    private val appContext: Context,
    private val localDataSource: LocalWalletDataSource
) : WalletRepository {

    override fun loadEthWallet(walletPassword: String): File {
        val walletFileName = localDataSource.loadEthWalletName(walletPassword)
        return File(appContext.filesDir.absolutePath, walletFileName)
    }

}