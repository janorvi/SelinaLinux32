package org.example

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle
import java.net.URL
import java.util.*

class MainController: Initializable {

    private val maintenanceFragmentName = "Maintenance.fxml"
    private val loginFragmentName = "Login.fxml"
    private val servicesFragmentName = "Services.fxml"
    private val routeTrackingFragmentName = "RouteTracking.fxml"
    private val serviceSummaryFragmentName = "ServiceSummary.fxml"

    private val routesDialogName = "Routes.fxml"
    private val notificationsDialogName = "Notifications.fxml"
    private val confirmCloseDialogName = "ConfirmClose.fxml"
    private val closeDialogName = "Close.fxml"
    private val messagesDialogName = "Messages.fxml"
    private val communicationsDialogName = "Communications.fxml"

    private var loginController: LoginController? = null
    private var servicesController: ServicesController? = null
    private var routeTrackingController: RouteTrackingController? = null
    private var routesController: RoutesController? = null
    private var serviceSummaryController: ServiceSummaryController? = null
    private var notificationsController: NotificationsController? = null
    private var confirmCloseController: ConfirmCloseController? = null
    private var closeController: CloseController? = null
    private var messagesController: MessagesController? = null
    private var communicationsController: CommunicationsController? = null

    @FXML var iconOneImageView: ImageView? = null
    @FXML var iconTwoImageView: ImageView? = null
    @FXML var iconThreeImageView: ImageView? = null
    @FXML var iconFourImageView: ImageView? = null
    @FXML var iconFiveImageView: ImageView? = null

    @FXML var contentAnchorPane: AnchorPane? = null

    @FXML var logoImageView: ImageView? = null

    @FXML var functionOneButton: Button? = null
    @FXML var functionTwoButton: Button? = null
    @FXML var functionThreeButton: Button? = null
    @FXML var functionFourButton: Button? = null
    @FXML var functionFiveButton: Button? = null

    @FXML var logoutImageView: ImageView? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        openFragment(loginFragmentName)

        iconOneImageView?.image = Image(javaClass.getResourceAsStream("/images/icon_one_disabled.png"))
        iconTwoImageView?.image = Image(javaClass.getResourceAsStream("/images/icon_two_disabled.png"))
        iconThreeImageView?.image = Image(javaClass.getResourceAsStream("/images/icon_three_disabled.png"))
        iconFourImageView?.image = Image(javaClass.getResourceAsStream("/images/icon_four_disabled.png"))
        iconFiveImageView?.image = Image(javaClass.getResourceAsStream("/images/icon_five_disabled.png"))
        logoImageView?.image = Image(javaClass.getResourceAsStream("/images/dashfleet.png"))
        logoutImageView?.image = Image(javaClass.getResourceAsStream("/images/cerrar_sesion.png"))

        functionOneButton?.setOnAction {
            openFragment(serviceSummaryFragmentName)
        }
        functionTwoButton?.setOnAction {
            openDialog(notificationsDialogName)
        }
        functionThreeButton?.setOnAction {
            openDialog(confirmCloseDialogName)
        }
        functionFourButton?.setOnAction {
            openDialog(messagesDialogName)
        }
        functionFiveButton?.setOnAction {
            openDialog(communicationsDialogName)
        }
        logoutImageView?.setOnMouseClicked {
            openFragment(loginFragmentName)
            setTopControlsVisibility(iconOneImageViewVisibility = false, iconTwoImageViewVisibility = false, iconThreeImageViewVisibility = false, iconFourImageViewVisibility = false, iconFiveImageViewVisibility = false)
            setBottomControlsVisibility(functionOneButtonVisibility = false, functionTwoButtonVisibility = false, functionThreeButtonVisibility = false, functionFourButtonVisibility = false, functionFiveButtonVisibility = false, logoutImageViewVisibility = false)
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
            serviceSummaryFragmentName -> {
                serviceSummaryController = fragmentLoader.getController<ServiceSummaryController>()
                serviceSummaryController?.successServiceSummaryButton?.setOnAction {
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
                    setTopControlsVisibility(iconOneImageViewVisibility = true, iconTwoImageViewVisibility = true, iconThreeImageViewVisibility = true, iconFourImageViewVisibility = true, iconFiveImageViewVisibility = true)
                    setBottomControlsVisibility(functionOneButtonVisibility = true, functionTwoButtonVisibility = true, functionThreeButtonVisibility = true, functionFourButtonVisibility = true, functionFiveButtonVisibility = true, logoutImageViewVisibility = true)
                    dialogStage.close()
                }
            }
            notificationsDialogName -> {
                notificationsController = dialogLoader.getController()
                notificationsController?.successNotificationButton?.setOnAction {
                    dialogStage.close()
                }
            }
            confirmCloseDialogName -> {
                confirmCloseController = dialogLoader.getController()
                confirmCloseController?.successCloseConfirmDialogButton?.setOnAction {
                    openDialog(closeDialogName)
                    dialogStage.close()
                }
                confirmCloseController?.closeConfirmCloseDialogButton?.setOnAction {
                    dialogStage.close()
                }
            }
            closeDialogName -> {
                closeController = dialogLoader.getController()
                closeController?.successCloseDialogButton?.setOnAction {
                    openFragment(loginFragmentName)
                    setTopControlsVisibility(iconOneImageViewVisibility = false, iconTwoImageViewVisibility = false, iconThreeImageViewVisibility = false, iconFourImageViewVisibility = false, iconFiveImageViewVisibility = false)
                    setBottomControlsVisibility(functionOneButtonVisibility = false, functionTwoButtonVisibility = false, functionThreeButtonVisibility = false, functionFourButtonVisibility = false, functionFiveButtonVisibility = false, logoutImageViewVisibility = false)
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

    private fun setTopControlsVisibility(iconOneImageViewVisibility: Boolean, iconTwoImageViewVisibility: Boolean, iconThreeImageViewVisibility: Boolean, iconFourImageViewVisibility: Boolean, iconFiveImageViewVisibility: Boolean){
        iconOneImageView?.isVisible = iconOneImageViewVisibility
        iconTwoImageView?.isVisible = iconTwoImageViewVisibility
        iconThreeImageView?.isVisible = iconThreeImageViewVisibility
        iconFourImageView?.isVisible = iconFourImageViewVisibility
        iconFiveImageView?.isVisible = iconFiveImageViewVisibility
    }

    private fun setBottomControlsVisibility(functionOneButtonVisibility: Boolean, functionTwoButtonVisibility: Boolean, functionThreeButtonVisibility: Boolean, functionFourButtonVisibility: Boolean, functionFiveButtonVisibility: Boolean, logoutImageViewVisibility: Boolean){
        functionOneButton?.isVisible = functionOneButtonVisibility
        functionTwoButton?.isVisible = functionTwoButtonVisibility
        functionThreeButton?.isVisible = functionThreeButtonVisibility
        functionFourButton?.isVisible = functionFourButtonVisibility
        functionFiveButton?.isVisible = functionFiveButtonVisibility
        logoutImageView?.isVisible = logoutImageViewVisibility
    }
}