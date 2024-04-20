package org.example

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import java.net.URL
import java.util.*

class LoginController: Initializable {

    @FXML
    var userTextView: TextField? = null
    @FXML
    var gridPanelKeyboard: GridPane? = null
    @FXML
    var gridPanelInformation: GridPane? = null
    @FXML
    var labelServices: Label? = null

    @FXML
    var enterButton: Button? = null

    @FXML
    var mainController: MainController? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {

    }

    @FXML
    fun hidePanels() {
        gridPanelKeyboard?.isVisible = false
        labelServices?.isVisible = true
        gridPanelKeyboard?.isVisible = false
        gridPanelInformation?.isVisible = false
    }
}