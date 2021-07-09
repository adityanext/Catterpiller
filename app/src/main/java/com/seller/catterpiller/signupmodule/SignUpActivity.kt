package com.seller.catterpiller.signupmodule

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.seller.catterpiller.DashBoardActivity
import com.seller.catterpiller.R
import com.seller.catterpiller.WebviewActivity
import com.seller.catterpiller.configutils.Cons
import com.seller.catterpiller.configutils.Validations
import com.seller.catterpiller.databinding.ActivitySignupBinding
import com.seller.catterpiller.loginmodule.LoginActivity
import com.seller.catterpiller.repositories.UserRepository
import com.seller.catterpiller.ui.auth.AuthViewModel
import com.seller.catterpiller.ui.auth.AuthViewModelFactory
import kotlinx.coroutines.launch

class SignUpActivity: AppCompatActivity()  {
    var context: Context? = null
    var ed_username: EditText? = null
    var username: String? = null
    var ed_useremail: EditText? = null
    var useremail: String? = null
    var ed_password: EditText? = null
    var ed_confirmpassword: EditText? = null
    var password: String? = null
    var confirmpassword: String? = null

//    override val kodein by kodein()
//    private val factory: AuthViewModelFactory by instance()
    private lateinit var repository: UserRepository

    private lateinit var binding: ActivitySignupBinding
    private lateinit var progressBar:ProgressBar
    private lateinit var viewModel: AuthViewModel

    val COMPANYlist=arrayOf ( "Samsung", "Harman", "Caterpillar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        context=this

        repository= UserRepository()
        setupViewModel()

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.dropdown_menu_popup_item, COMPANYlist)
        binding.spinnercompanylist.setAdapter(adapter);

        binding.termscondition.setOnClickListener(View.OnClickListener {
            val i = Intent(context, WebviewActivity::class.java)
            i.putExtra("Heading", "TERMS AND CONDITION")
            i.putExtra("URL", Cons.ABOUTUSURL)
            startActivity(i)
        })


        binding.logintext.setOnClickListener(View.OnClickListener {
            val i = Intent(context, LoginActivity::class.java)
            startActivity(i)
        })

//        setupUI()


    }

    fun textCancel(view: View) {
        finish()

    }

    fun OnSignUpButton(view: View) {
        username = binding.edUsername.text.toString()
        useremail = binding.edUseremail.text.toString()
        password = binding.edPassword.text.toString()
        confirmpassword = binding.edConfirmpassword.text.toString()


        when {
            useremail == "" -> {
                Validations.ShowToast(
                    context,
                    "Enter email"
                )
                return

            }
//            Validations.isValidEmail(useremail,context) -> {
//                Validations.ShowToast(
//                    context,
//                    "Enter valid email"
//                )
//            }
            username == "" -> {
                Validations.ShowToast(
                    context,
                    "Enter username"
                )
                return

            }
            password == "" -> {
                Validations.ShowToast(
                    context,
                    "Enter Password"
                )
                return

            }

            else -> if(!Validations.isValidPassword(password)) {
                Validations.ShowToast(
                    context,
                    "Enter valid password"
                )
                 return
            }

//            else -> if (Validations.isValidConfirmPassword(password, confirmpassword, context)) {
//
//            }
        }
        userSignup()


//
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, AuthViewModelFactory(repository)).get(AuthViewModel::class.java)
//
//        viewModel = ViewModelProviders.of(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))).get(AuthViewModel::class.java)
    }

//    private fun setupUI() {
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        adapter = MainAdapter(arrayListOf())
//        recyclerView.addItemDecoration(
//            DividerItemDecoration(
//                recyclerView.context,
//                (recyclerView.layoutManager as LinearLayoutManager).orientation
//            )
//        )
//        recyclerView.adapter = adapter
//    }

//    private fun setupObservers() {
//        viewModel.addnewUsers().observe(this, Observer {
//            it?.let { resource ->
//                when (resource.status) {
//                    SignupStatus.SUCCESS -> {
////                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
//                        resource.data?.let { users -> retrieveList(users) }
//
//                        setupintent()
//                    }
//                    SignupStatus.ERROR -> {
//                        progressBar.visibility = View.GONE
//                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
//                    }
//                    SignupStatus.LOADING -> {
//                        progressBar.visibility = View.VISIBLE
//                    }
//                }
//            }
//        })
//    }

    private fun setupintent() {
        val intent = Intent(context, DashBoardActivity::class.java)
        startActivity(intent)
    }

    private fun retrieveList(response: String) {
        Log.e("retrieveresponse: ",response )
//        adapter.apply {
//            addUsers(users)
//            notifyDataSetChanged()
//        }
    }





    fun OnLoginButton(view: View) {
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun userSignup() {

        binding.progressBar.visibility=View.VISIBLE
        val name = binding.edUsername.text.toString().trim()
        val email = binding.edUseremail.text.toString().trim()
        val password = binding.edPassword.text.toString().trim()
        val cpassword = binding.edConfirmpassword.text.toString().trim()

        //@todo add input validations


        lifecycleScope.launch {
            try {
                val authResponse = viewModel.userSignup("http://192.151.131.114/?apikey=XL7D89g9j7d5tkVdexFwd24MJB3GJHJ7&action=pbxware.ext.add&server=10&name=$name&email=$email&location=2&ua=50&status=1&pin=1234&incominglimit=2&outgoinglimit=2&voicemail=1&prot=sip&secret=$password")
                binding.progressBar.visibility=View.GONE

                Log.e("AuthResponsetrue",authResponse.body().toString())
                if (authResponse. isSuccessful) {
                    Validations.ShowToast(
                        context,
                        "Account created successfully"
                    )
                    finish()
                    authResponse.body()?.success
                    Log.e("AuthResponse3",authResponse.body()?.success.toString())

//                    viewModel.saveLoggedInUser(authResponse.user)
                } else {
//                    binding.root.snackbar(authResponse.message!!)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
//            } catch (e: NoInternetException) {
//                e.printStackTrace()
//            }
        }
    }

}