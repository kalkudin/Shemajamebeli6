package com.example.shemajamebeli5.sample_fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli5.base_fragment.BaseFragment
import com.example.shemajamebeli5.databinding.FragmentSampleBinding
import kotlinx.coroutines.launch

class SampleFragment :
    BaseFragment<FragmentSampleBinding>(FragmentSampleBinding::inflate) {

    private val viewModel: SampleFragmentViewModel by viewModels()
    private val horizontalAdapter = SampleHorizontalRecyclerAdapter()
    private val verticalAdapter = SampleVerticalRecyclerAdapter()

    override fun setUp() {
        setUpHorizontalRecyclerView()
        setUpVerticalRecyclerView()

        // Fetch data from API
        viewModel.fetchData()

        // Observe API response
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.apiResponse.collect { response ->
                    if (response != null) {
                        horizontalAdapter.submitList(response.newCourse)
                        verticalAdapter.submitList(response.activeCourse)
                    } else {
                        // Handle the case when data is not available
                    }
                }
            }
        }
    }

    private fun setUpHorizontalRecyclerView() {
        binding.horizontalRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.horizontalRecyclerView.adapter = horizontalAdapter
    }

    private fun setUpVerticalRecyclerView() {
        binding.verticalRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())
        binding.verticalRecyclerView.adapter = verticalAdapter
    }
}