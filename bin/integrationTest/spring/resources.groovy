import com.app.UserPasswordEncoderListener
import com.app.UserCredentialsService
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    userDetailsService(UserCredentialsService)
}
