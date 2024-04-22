package org.example

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.AnchorPane
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle
import java.net.URL
import java.util.*

class MainController: Initializable {

    private val loginFragmentName = "Login.fxml"
    private val servicesFragmentName = "Services.fxml"
    private val routeTrackingFragmentName = "RouteTracking.fxml"

    private val routesDialogName = "Routes.fxml"
    private val confirmCloseDialogName = "ConfirmClose.fxml"
    private val messagesDialogName = "Messages.fxml"
    private val communicationsDialogName = "Communications.fxml"

    private var loginController: LoginController? = null
    private var servicesController: ServicesController? = null
    private var routeTrackingController: RouteTrackingController? = null
    private var routesController: RoutesController? = null
    private var confirmCloseController: ConfirmCloseController? = null
    private var messagesController: MessagesController? = null
    private var communicationsController: CommunicationsController? = null

    @FXML var contentAnchorPane: AnchorPane? = null

    @FXML var functionOneButton: Button? = null
    @FXML var functionTwoButton: Button? = null
    @FXML var functionThreeButton: Button? = null
    @FXML var logoutButton: Button? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        openFragment(loginFragmentName)
        functionOneButton?.setOnAction {
            openDialog(confirmCloseDialogName)
        }
        functionTwoButton?.setOnAction {
            openDialog(messagesDialogName)
        }
        functionThreeButton?.setOnAction {
            openDialog(communicationsDialogName)
        }
        logoutButton?.setOnAction {
            openFragment(loginFragmentName)
            setButtonsVisibility(functionOneButtonVisibility = false, functionTwoButtonVisibility = false, functionThreeButtonVisibility = false, logoutButtonVisibility = false)
        }
    }

    private fun openFragment(fragmentName: String){
        val fragmentLoader = FXMLLoader(javaClass.classLoader.getResource(fragmentName))
        val fragmentRoot = fragmentLoader.load<Parent>()

        when(fragmentName){
            loginFragmentName -> {
                loginController = fragmentLoader.getController<LoginController>()
                loginController?.enterButton?.setOnAction {
                    openDialog(routesDialogName)
                }
            }
            servicesFragmentName -> {
                servicesController = fragmentLoader.getController<ServicesController>()
                servicesController?.initServiceButton?.setOnAction {
                    openFragment(routeTrackingFragmentName)
                }
            }
            routeTrackingFragmentName -> {
                routeTrackingController = fragmentLoader.getController<RouteTrackingController>()
                routeTrackingController?.closeRouteTrackingFragmentButton?.setOnAction {
                    openFragment(servicesFragmentName)
                }
            }
        }

        contentAnchorPane?.children?.setAll(fragmentRoot)
    }

    private fun openDialog(dialogName: String){
        val dialogLoader = FXMLLoader(javaClass.classLoader.getResource(dialogName))
        val dialogRoot = dialogLoader.load<Parent>()
        val dialogStage = Stage()

        dialogStage.initModality(Modality.APPLICATION_MODAL)
        dialogStage.initStyle(StageStyle.UNDECORATED)
        dialogStage.scene = Scene(dialogRoot)

        when(dialogName){
            routesDialogName -> {
                routesController = dialogLoader.getController()
                routesController?.closeRoutesDialogButton?.setOnAction {
                    dialogStage.close()
                }
                routesController?.firstRouteButton?.setOnAction {
                    openFragment(servicesFragmentName)
                    setButtonsVisibility(functionOneButtonVisibility = true, functionTwoButtonVisibility = true, functionThreeButtonVisibility = true, logoutButtonVisibility = true)
                    dialogStage.close()
                }
            }
            confirmCloseDialogName -> {
                confirmCloseController = dialogLoader.getController()
                confirmCloseController?.closeConfirmCloseDialogButton?.setOnAction {
                    dialogStage.close()
                }
            }
            messagesDialogName -> {
                messagesController = dialogLoader.getController()
                messagesController?.closeMessagesDialogButton?.setOnAction {
                    dialogStage.close()
                }
            }
            communicationsDialogName -> {
                communicationsController = dialogLoader.getController()
                communicationsController?.closeCommunicationsDialogButton?.setOnAction {
                    dialogStage.close()
                }
            }
        }

        dialogStage.showAndWait()
    }

    private fun setButtonsVisibility(functionOneButtonVisibility: Boolean, functionTwoButtonVisibility: Boolean, functionThreeButtonVisibility: Boolean, logoutButtonVisibility: Boolean, ){
        functionOneButton?.isVisible = functionOneButtonVisibility
        functionTwoButton?.isVisible = functionTwoButtonVisibility
        functionThreeButton?.isVisible = functionThreeButtonVisibility
        logoutButton?.isVisible = logoutButtonVisibility
    }
}