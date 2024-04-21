package org.example

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.layout.AnchorPane
import java.net.URL
import java.util.*

class MainController: Initializable {

    @FXML var contentAnchorPane: AnchorPane? = null

    @FXML var functionOneButton: Button? = null
    @FXML var functionTwoButton: Button? = null
    @FXML var functionThreeButton: Button? = null
    @FXML var logoutButton: Button? = null

    private var loginController: LoginController? = null
    private var servicesController: ServicesController? = null

    private val loginFragmentName = "Login.fxml"
    private val servicesFragmentName = "Services.fxml"

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        openFragment(loginFragmentName)
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
                    openFragment(servicesFragmentName)
                    setButtonsVisibility(functionOneButtonVisibility = true, functionTwoButtonVisibility = true, functionThreeButtonVisibility = true, logoutButtonVisibility = true)
                }
            }
            servicesFragmentName -> {
                servicesController = fragmentLoader.getController<ServicesController>()
            }
        }
        contentAnchorPane?.children?.setAll(fragmentRoot)
    }

    private fun setButtonsVisibility(functionOneButtonVisibility: Boolean, functionTwoButtonVisibility: Boolean, functionThreeButtonVisibility: Boolean, logoutButtonVisibility: Boolean, ){
        functionOneButton?.isVisible = functionOneButtonVisibility
        functionTwoButton?.isVisible = functionTwoButtonVisibility
        functionThreeButton?.isVisible = functionThreeButtonVisibility
        logoutButton?.isVisible = logoutButtonVisibility
    }


}