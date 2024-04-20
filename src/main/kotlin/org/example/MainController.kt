package org.example

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.GridPane
import java.net.URL
import java.util.*

class MainController: Initializable {

    @FXML var contentAnchorPane: AnchorPane? = null

    @FXML var functionOneButton: Button? = null
    @FXML var functionTwoButton: Button? = null
    @FXML var functionThreeButton: Button? = null
    @FXML var logoutButton: Button? = null

    @FXML var showLoginButton: Button? = null

    @FXML var userTextView: TextField? = null
    @FXML var gridPanelKeyboard: GridPane? = null
    @FXML var gridPanelInformation: GridPane? = null
    @FXML var labelServices: Label? = null
    @FXML var enterButton: Button? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {



    }

    @FXML fun showLogin(){

    }

    @FXML fun showButtons(){
        functionOneButton?.isVisible = true
        functionTwoButton?.isVisible = true
        functionThreeButton?.isVisible = true
        logoutButton?.isVisible = true
        gridPanelKeyboard?.isVisible = false
        labelServices?.isVisible = true
        gridPanelKeyboard?.isVisible = false
        gridPanelInformation?.isVisible = false

        val algo = javaClass.classLoader.getResource("Services.fxml")
        val loginAnchorPane = FXMLLoader.load<Parent>(algo)
        contentAnchorPane?.children?.setAll(loginAnchorPane)
    }

    @FXML fun hideButtons(){
        functionOneButton?.isVisible = false
        functionTwoButton?.isVisible = false
        functionThreeButton?.isVisible = false
        logoutButton?.isVisible = false
        gridPanelKeyboard?.isVisible = true
        labelServices?.isVisible = true
        gridPanelKeyboard?.isVisible = false
        gridPanelInformation?.isVisible = false

        val algo = javaClass.classLoader.getResource("Login.fxml")
        val loginAnchorPane = FXMLLoader.load<Parent>(algo)
        contentAnchorPane?.children?.setAll(loginAnchorPane)
    }
}