package fr.asaddour.ethsample.di

import android.content.Context
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.asaddour.ethsample.BuildConfig
import fr.asaddour.ethsample.data.wallet.LocalWalletDataSource
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideEthClient() = Web3j.build(
        HttpService("https://ropsten.infura.io/v3/${BuildConfig.infuraApiKey}")
    )

    @Provides
    @Singleton
    fun provideLocalWalletDataSource(@ApplicationContext appContext: Context): LocalWalletDataSource {
        return LocalWalletDataSource(appContext)
    }

}
