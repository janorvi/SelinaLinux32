package org.example

import javafx.application.Application
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import java.net.URL
import java.util.*

class LoginController: Initializable {

    @FXML var userTextView: TextField? = null
    @FXML var gridPanelKeyboard: GridPane? = null
    @FXML var gridPanelInformation: GridPane? = null
    @FXML var labelServices: Label? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        println(userTextView?.text)
    }

    @FXML fun hidePanels(){
        labelServices?.isVisible = true
        gridPanelKeyboard?.isVisible = false
        gridPanelInformation?.isVisible = false

    }

}