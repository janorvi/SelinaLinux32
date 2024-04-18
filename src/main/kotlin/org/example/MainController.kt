package org.example

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Parent
import javafx.scene.layout.AnchorPane
import java.net.URL
import java.util.*

class MainController: Initializable {

    @FXML val contentAnchorPane: AnchorPane? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        /*contentAnchorPane?.children?.clear()
        val loginAnchorPane = FXMLLoader.load<Parent>(javaClass.classLoader.getResource("Login.fxml"))
        contentAnchorPane?.children?.add(loginAnchorPane)*/
    }

    @FXML fun showLogin(){
        contentAnchorPane?.children?.clear()
        val loginAnchorPane = FXMLLoader.load<Parent>(javaClass.classLoader.getResource("Login.fxml"))
        contentAnchorPane?.children?.add(loginAnchorPane)
    }
}