package fr.asaddour.ethsample.domain.eth

import org.web3j.crypto.Credentials
import org.web3j.protocol.core.RemoteCall
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.utils.Convert
import java.math.BigDecimal

interface EthRepository {

    fun getCredentials(walletPassword: String): Credentials

    fun sendFunds(
        credentials: Credentials,
        toAddress: String,
        value: BigDecimal,
        unit: Convert.Unit
    ): RemoteCall<TransactionReceipt>

}