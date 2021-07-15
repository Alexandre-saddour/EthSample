package fr.asaddour.ethsample.data.eth

import android.util.Log
import fr.asaddour.ethsample.domain.eth.EthRepository
import fr.asaddour.ethsample.domain.wallet.WalletRepository
import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.RemoteCall
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.tx.Transfer
import org.web3j.utils.Convert
import java.math.BigDecimal
import javax.inject.Inject

class EthRepositoryImpl @Inject constructor(
    private val client: Web3j,
    private val walletRepository: WalletRepository
) : EthRepository {

    override fun getCredentials(walletPassword: String) = WalletUtils.loadCredentials(
        walletPassword,
        walletRepository.loadEthWallet(walletPassword)
    ).also {
        Log.d("EthRepositoryImpl", "loading credentials: ${it.address}")
    }

    override fun sendFunds(
        credentials: Credentials,
        toAddress: String,
        value: BigDecimal,
        unit: Convert.Unit
    ): RemoteCall<TransactionReceipt> {
        return Transfer.sendFunds(client, credentials, toAddress, value, unit)
    }

}