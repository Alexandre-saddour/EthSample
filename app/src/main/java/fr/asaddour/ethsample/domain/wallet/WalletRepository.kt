package fr.asaddour.ethsample.domain.wallet

import java.io.File

interface WalletRepository {

    fun loadEthWallet(walletPassword: String): File

}