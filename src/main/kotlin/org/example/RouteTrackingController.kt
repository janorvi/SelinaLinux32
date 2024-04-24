package org.example

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.net.URL
import java.util.*

class RouteTrackingController: Initializable {

    @FXML var imageView: ImageView? = null
    @FXML var nextBusETAImageView: ImageView? = null
    @FXML var currentBusETAImageView: ImageView? = null
    @FXML var previousBusETAImageView: ImageView? = null

    @FXML var closeRouteTrackingFragmentButton: Button? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        imageView?.image = Image(javaClass.getResourceAsStream("/images/route_service_background.png"))
        nextBusETAImageView?.image = Image(javaClass.getResourceAsStream("/images/bus_siva.png"))
        currentBusETAImageView?.image = Image(javaClass.getResourceAsStream("/images/bus_siva.png"))
        previousBusETAImageView?.image = Image(javaClass.getResourceAsStream("/images/bus_siva.png"))
    }
}