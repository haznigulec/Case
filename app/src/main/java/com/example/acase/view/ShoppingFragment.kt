package com.example.acase.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.acase.R
import com.example.acase.adapter.ShoppingAdapter
import com.example.acase.databinding.FragmentShoppingBinding
import com.example.acase.model.ShoppingItems
import com.example.acase.viewmodel.ShoppingViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingFragment : Fragment() {

    private lateinit var binding : FragmentShoppingBinding
    private lateinit var viewModel : ShoppingViewModel
    private lateinit var itemAdapter : ShoppingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {


        binding = FragmentShoppingBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ShoppingViewModel::class.java)
       // viewModel.loadData()

        itemAdapter = ShoppingAdapter(ArrayList(), viewModel)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = itemAdapter

        observeData()





        binding.delete.setOnClickListener {
            viewModel.clearItems()
            itemAdapter.clearItems()
        }

        binding.history.setOnClickListener{
            findNavController().navigate(R.id.action_shoppingFragment_to_historyFragment)
        }
        binding.complete.setOnClickListener {


                /*viewModel.saveData()
                viewModel.clearItems()
                itemAdapter.clearItems()


                 */

            findNavController().navigate(R.id.action_shoppingFragment_to_historyFragment)
        }

        binding.add.setOnClickListener {
            val itemName = binding.edit.text.toString()

            if (itemName.isNotBlank()) {
                viewModel.addItem(ShoppingItems(itemName, 1,))
                binding.edit.text.clear()
                // CoroutineScope(Dispatchers.IO).launch {
                   // viewModel.saveData() }
            }
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        itemAdapter.clearItems() // clear the adapter
        viewModel.loadData() // reload the data from the ViewModel
    }

    override fun onStop() {
        super.onStop()
        CoroutineScope(Dispatchers.IO).launch {
          viewModel.saveData() }
    }






    private fun observeData() {
        viewModel.items.observe(viewLifecycleOwner, Observer { things ->
            things?.let {
                binding.recyclerView.visibility = View.VISIBLE
                itemAdapter.updateList(things)

                if (things.isNotEmpty()) {
                    binding.delete.visibility = View.VISIBLE
                    binding.errorText.visibility = View.GONE
                } else {
                    binding.delete.visibility = View.GONE
                    binding.errorText.visibility = View.VISIBLE
                }
            }

        })
        viewModel.firstError.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                if (it) {
                    binding.errorText.visibility = View.VISIBLE
                } else {
                    binding.errorText.visibility = View.GONE
                }
            }
        })
    }
}