package org.example

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.net.URL
import java.util.*

class NotificationsController: Initializable {

    @FXML var notificationImageView: ImageView? = null
    @FXML var notificationLabel: Label? = null
    @FXML var successNotificationButton: Button? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        notificationImageView?.image = Image(javaClass.getResourceAsStream("/images/advice.png"))
    }
}