package fr.asaddour.ethsample.domain.eth

import org.web3j.protocol.core.RemoteCall
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.utils.Convert
import java.math.BigDecimal
import javax.inject.Inject

class SendFundsUsecase @Inject constructor(
    private val ethRepository: EthRepository
) {

    fun execute(
        walletPassword: String,
        toAddress: String,
        value: BigDecimal,
        unit: Convert.Unit
    ): RemoteCall<TransactionReceipt> {
        return ethRepository.sendFunds(
            ethRepository.getCredentials(walletPassword),
            toAddress,
            value,
            unit
        )
    }
}