package com.kailashdabhi.headytest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kailashdabhi.headytest.base.Resource
import com.kailashdabhi.headytest.base.Status.ERROR
import com.kailashdabhi.headytest.base.Status.LOADING
import com.kailashdabhi.headytest.base.Status.SUCCESS
import com.kailashdabhi.headytest.data.database.Product
import kotlinx.android.synthetic.main.fragment_product.progress
import kotlinx.android.synthetic.main.fragment_product.recyclerView

/**
 * @author kailash09dabhi@gmail.com
 * @date 22, Jan 2020 (11:18)
 */
class ProductFragment : Fragment() {
  companion object {
    fun newInstance() = ProductFragment()
  }

  private val viewModel by viewModels<ProductViewModel>()
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_product, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setHasOptionsMenu(true)
    viewModel.products().observe(viewLifecycleOwner, Observer {
      when (it.status) {
        SUCCESS -> {
          showList(it)
        }
        ERROR -> {
          Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
          showList(it)
        }
        LOADING -> {
          progress.visibility = View.VISIBLE
          recyclerView.visibility = View.GONE
        }
      }
    })
  }

  private fun showList(it: Resource<List<Product>>) {
    progress.visibility = View.GONE
    recyclerView.visibility = View.VISIBLE
    recyclerView.layoutManager = LinearLayoutManager(context)
    recyclerView.adapter = ProductAdapter(it.data ?: listOf())
  }

  override fun onCreateOptionsMenu(
    menu: Menu,
    inflater: MenuInflater
  ) {
    super.onCreateOptionsMenu(menu, inflater)
    inflater.inflate(R.menu.product, menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val id = item.itemId
    when (id) {
      R.id.action_sortingByShareCount -> {
        recyclerView.adapter?.let {
          val sortedBy = (it as ProductAdapter).items.sortedBy { it.shareCount }.asReversed()
          recyclerView.adapter = ProductAdapter(sortedBy)
        }
      }
      R.id.action_sortingByOrderCount -> {
        recyclerView.adapter?.let {
          val sortedBy = (it as ProductAdapter).items.sortedBy { it.orderCount }.asReversed()
          recyclerView.adapter = ProductAdapter(sortedBy)
        }

      }
      R.id.action_sortingByViewCount -> {
        recyclerView.adapter?.let {
          val sortedBy = (it as ProductAdapter).items.sortedBy { it.viewCount }.asReversed()
          recyclerView.adapter = ProductAdapter(sortedBy)
        }
      }
    }
    return true
  }
}