/**
 *
 */


$(function(){
	//$(".nametbl").hide();
	$('[name="nameDo_Not"]:radio').change( function() {
		if ($('[id="m1"]').prop('checked')) {
			//$("#m1").bind("click", function(){
				$(this.form).find(":checked").prop("checked", false);//$(this.form).find("textarea, :text, select").val("").end().find(":checked").prop("checked", false);

			$('.nametbl').hide();
		}else if ($('[id="m2"]').prop('checked')) {
	    	 $('.nametbl').show();
	    }
	});
});