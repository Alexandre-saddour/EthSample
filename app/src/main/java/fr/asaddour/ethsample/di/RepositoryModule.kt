package fr.asaddour.ethsample.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.asaddour.ethsample.data.eth.EthRepositoryImpl
import fr.asaddour.ethsample.data.wallet.LocalWalletDataSource
import fr.asaddour.ethsample.data.wallet.WalletRepositoryImpl
import fr.asaddour.ethsample.domain.eth.EthRepository
import fr.asaddour.ethsample.domain.wallet.WalletRepository
import org.web3j.protocol.Web3j

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideWalletRepository(
        @ApplicationContext appContext: Context,
        localWalletDataSource: LocalWalletDataSource
    ): WalletRepository {
        return WalletRepositoryImpl(appContext, localWalletDataSource)
    }


    @Provides
    fun provideEthRepository(
        client: Web3j,
        walletRepository: WalletRepository,
    ): EthRepository {
        return EthRepositoryImpl(client, walletRepository)
    }

}
