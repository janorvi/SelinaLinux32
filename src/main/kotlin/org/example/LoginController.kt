package org.example

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.net.URL
import java.util.*

class LoginController: Initializable {

    @FXML var loginInfoImageView: ImageView? = null

    @FXML var enterButton: Button? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        loginInfoImageView?.image = Image(javaClass.getResourceAsStream("/images/bus.png"))
    }
}