### Flow

On launching the app, the RecipesActivity is invoked (as it is the entry point as declared in the manifest file)

RecipesActivity lays out its UI from activity_main.xml, which contains a \<fragment\> tag with class RecipesFragment

The RecipesFragment which extends ListFragment is instantiated and it's lifecycle started
(as it has to display a list of recipes)

The RecipesFragment configures the list adapter and loads data from the RecipesModel to display a list of recipes

The RecipesFragment also defines the action to take when an item from the list is clicked in its
 onListItemClick callback

On clicking an item, the RecipesFragment calls a method on the RecipesActivity's instance (that it holds on to) with the
index of the item clicked. This method defined in RecipesActivity sends an intent to RecipeStepsActivity after
attaching the index of the item clicked to the intent

The RecipeStepsActivity calls the factory method in RecipeStepsFragment to dynamically create a RecipeStepsFragment
and attach an initialization bundle with the index of the item clicked

The RecipeStepsFragment displays the STEPS content of the model with the right index in one of its callbacks.

### Notes

RecipesFragment is defined in RecipesActivity's layout file with a \<fragment\> tag.
It extends ListFragment
Its view is inflated from android.R.layout.simple_list_item_1 in its onActivityCreated() method

RecipeStepsFragments are defined dynamically in RecipeStepsActivity.
RecipeStepsFragments extend Fragment
Its view is inflated from layout/recipe_steps.xml in its onCreateView() method
