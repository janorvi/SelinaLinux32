package org.example

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.net.URL
import java.util.*

class ConfirmCloseController:Initializable {

    @FXML var schoolBusImageView: ImageView? = null
    @FXML var cashRegisterImageView: ImageView? = null
    @FXML var circleOneImageView: ImageView? = null
    @FXML var circleTwoImageView: ImageView? = null
    @FXML var circleThreeImageView: ImageView? = null
    @FXML var ticketImageView: ImageView? = null

    @FXML var successCloseConfirmDialogButton: Button? = null
    @FXML var closeConfirmCloseDialogButton: Button? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        schoolBusImageView?.image = Image(javaClass.getResourceAsStream("/images/bus_school.png"))
        cashRegisterImageView?.image = Image(javaClass.getResourceAsStream("/images/caja.png"))
        circleOneImageView?.image = Image(javaClass.getResourceAsStream("/images/circle.png"))
        circleTwoImageView?.image = Image(javaClass.getResourceAsStream("/images/circle.png"))
        circleThreeImageView?.image = Image(javaClass.getResourceAsStream("/images/circle.png"))
        ticketImageView?.image = Image(javaClass.getResourceAsStream("/images/ticketpago.png"))
    }
}