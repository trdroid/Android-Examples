### Flow

On launching the app, the RecipesActivity is invoked (as it is the entry point as declared in the manifest file)

RecipesActivity lays out its UI from activity_main.xml, which contains a \<fragment\> tag with class RecipesFragment

The RecipesFragment is instantiated and it's lifecycle is started

The RecipesFragment configures the list adapter and loads data from the RecipesModel to display a list of recipes

The RecipesFragment also defines what should happen when an item from the list is clicked.

On clicking an item, the RecipesFragment calls a method on the RecipesActivity's instance (that it holds on to) with the
index of the item clicked. The method launches the RecipeStepsActivity

The RecipeStepsActivity creates a new RecipeStepsFragment and also passes in the index of the item clicked

The RecipeStepsFragment displays the STEPS content of the model with the right index.

### Observations

RecipesFragment is defined in RecipesActivity's layout file with a \<fragment\> tag

RecipeStepsFragments are defined dynamically in RecipeStepsActivity
