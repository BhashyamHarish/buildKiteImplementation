package com.saucelabs.mydemoapp.android.testSuites
import com.saucelabs.mydemoapp.android.e2eTests.login.LoginTest
import com.saucelabs.mydemoapp.android.e2eTests.logout.LogOutTest

import com.saucelabs.mydemoapp.android.e2eTests.productPurchase.ProductPurchaseTest
import org.junit.runner.RunWith
import org.junit.runners.Suite




@RunWith(Suite::class)
@Suite.SuiteClasses(
    LoginTest::class,
    LogOutTest::class,
    ProductPurchaseTest::class
)

class MyTestSuite{


}