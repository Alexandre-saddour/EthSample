package fr.asaddour.ethsample.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.asaddour.ethsample.domain.eth.SendFundsUsecase
import org.web3j.protocol.core.RemoteCall
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.utils.Convert
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val sendFundsUsecase: SendFundsUsecase
) : ViewModel() {

    fun sendFunds(): RemoteCall<TransactionReceipt> {
        return sendFundsUsecase.execute(
            walletPassword = "pass",
            toAddress = "0x83fbacf88f5c2f152c22f996bca1c241efbf89bf",
            value = BigDecimal(1000000000),
            unit = Convert.Unit.WEI
        )
    }

}