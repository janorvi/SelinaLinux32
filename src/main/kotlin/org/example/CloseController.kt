package org.example

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.net.URL
import java.util.*

class CloseController: Initializable {

    @FXML var cashRegisterImageView: ImageView? = null
    @FXML var successCloseDialogButton: Button? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cashRegisterImageView?.image = Image(javaClass.getResourceAsStream("/images/caja.png"))
    }
}