package org.example

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.example.data.model.LoginSaeModel
import org.example.data.network.RetrofitClientMain
import java.net.URL
import java.util.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class LoginController : Initializable, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default
    @FXML
    var userTextView: TextField? = null
    @FXML
    var gridPanelKeyboard: GridPane? = null
    @FXML
    var gridPanelInformation: GridPane? = null
    @FXML
    var labelServices: Label? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        println(userTextView?.text)
    }

    @FXML
    fun hidePanels() {
        labelServices?.isVisible = true
        gridPanelKeyboard?.isVisible = false
        gridPanelInformation?.isVisible = false
        login()
    }

    private fun login() {

        val loginRequest = LoginSaeModel(
            imei = "1234567890",
            email = "dashfleet@test.com",
            password = "1234",
            deviceName = "dashfleettest"
        )

        launch {
            RetrofitClientMain.webserviceMain.loginSae(loginRequest)
        }
    }
}