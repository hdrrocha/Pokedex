import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.Pager
import androidx.paging.PagingData
import com.example.pokedex.helper.CoroutinesTestRule
import com.example.pokedex.helper.PagingDataTest
import com.example.pokedex.domain.repository.PokemonListRepository
import com.google.common.truth.Truth.assertThat
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.repository.PokemonListRepositoryImp
import com.example.pokedex.data.repository.PokemonsFactory
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PokemonListRepositoryImpTest : PagingDataTest() {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    @get:Rule
    @ExperimentalCoroutinesApi
    val coroutineRule = CoroutinesTestRule()

    @MockK
    private lateinit var mockPager: Pager<Int, Pokemon>

    private lateinit var sut: PokemonListRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        sut = PokemonListRepositoryImp(pager = mockPager)
    }

    @Test
    fun fetchImagesSuccessTest() = runBlocking {
        val expected = PokemonsFactory.pokemonList
        every { mockPager.flow }.returns(flowOf(PagingData.from(expected)))

        sut.fetchPokemon().collect {
            val actual = getDifferSnapshot(it)

            assertThat(actual).isNotEmpty()
            assertThat(actual.items).isNotEmpty()
            assertThat(actual.items).isEqualTo(expected)
        }
    }

    @Test
    fun fetchImagesErrorTest() = runBlocking {
        every { mockPager.flow }.returns(flowOf(PagingData.empty()))

        val data = sut.fetchPokemon().singleOrNull()
        val actual = getDifferSnapshot(data!!)

        assertThat(actual).isEmpty()
    }
}
