package net.pradana.movie.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.pradana.core.data.Resource
import net.pradana.core.domain.model.Movie
import net.pradana.core.ui.MovieAdapter
import net.pradana.core.utils.makeVisible
import net.pradana.movie.databinding.DisplayFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by viewModel()
    private var _binding: DisplayFragmentBinding? = null
    private val binding get() = _binding!!
    val movieAdapter = MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DisplayFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.rvMovies) {
            setHasFixedSize(true)
            adapter = movieAdapter
        }

        initObserver()
        binding.swapRefresh.setOnRefreshListener { initObserver() }
    }

    private fun initObserver() {
        if (activity != null) {
//            movieAdapter.onItemClick = {
////                val inten = Intent(activity, MainActivity::class.java)
//            }

            movieViewModel.movies.observe(viewLifecycleOwner, {
                if (it != null) {
                    when (it) {
                        is Resource.Loading -> toggleLoading(true)
                        is Resource.Success -> {
                            toggleLoading(false)
                            movieAdapter.setData(it.data)
                        }
                        is Resource.Error -> {
                            toggleLoading(false)
                            binding.layoutError.root.makeVisible()
                        }
                    }
                }
            })
        }
    }

    private fun toggleLoading(loading: Boolean) {
        binding.swapRefresh.isRefreshing = loading
    }

    private fun showData(data:List<Movie>){

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}