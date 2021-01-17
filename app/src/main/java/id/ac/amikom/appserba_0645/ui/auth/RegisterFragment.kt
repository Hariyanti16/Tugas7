package id.ac.amikom.appserba_0645.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import id.ac.amikom.appserba_0645.R
import id.ac.amikom.appserba_0645.data.repository.AuthRepository
import id.ac.amikom.appserba_0645.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    val parent: AuthActivity by lazy { activity as AuthActivity}
    val viewModel: AuthViewModel by lazy {AuthViewModel(AuthRepository(parent))}
    lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel=viewModel
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
    }

    private fun observe() {
        viewModel.authRegister.observe(viewLifecycleOwner){
            if (it.isCosumed){
                Log.i("Register", "isCosumed")
            } else if (!it.isSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
            }
            it.isCosumed = true
        }
    }

    private fun init() {
        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
        }
    }
}