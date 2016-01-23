/*package ort.geekstagram_student;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ort.geekstagram_student.controllers.PostController;
import ort.geekstagram_student.posts.service.PostService;

public class PostControllerTest {

	@Mock
	private PostService postService;

	@InjectMocks
	private PostController postController;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(postController).build();

	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}*/
