<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="common/taglibs.jsp"%>

	<link rel="stylesheet" href="<c:url value="/css/dashboard.css"/>" />
 	<link rel="stylesheet" href="<c:url value="/css/radio.css"/>" />
 	<link rel="stylesheet" href="<c:url value="/css/modal.css"/>" />
	<style type="text/css">
		.submit-btns{
			padding-top: 15px;
		}
	</style>
	

	<!-- confirm navigation bar  -->
	<!-- class padding if you want to put content -->
	<div class="padding">
		<div class="container-fluid">
			<div class="row">
				<div class="center" style="margin-top:25px">
					<div class="col-xs-12 col-sm-6" style="margin-bottom:5px">
					<a href="#" data-toggle="modal" data-target="#brewnow">
						<button class="btn btn-primary btn-brew btn-block" data-toggle="tooltip" data-placement="top">Brew now</button></a>
					</div>
					<div class="col-xs-12 col-sm-6" style="margin-bottom:5px">
					<a href="#" data-toggle="modal" data-target="#schedbrew">
						<button class="btn btn-primary btn-brew btn-block" data-toggle="tooltip" data-placement="top">Schedule</button></a>
					</div>
					<!-- <div class="col-xs-12 col-sm-4">
					<a href="#" data-toggle="modal" data-target="#roundspaceModal">
						<button class="btn btn-primary btn-block">Analytics</button></a>
					</div>	 -->
				</div>
			</div>
			
			<div class="row" id="queueSection">
				<table class="table table-hover table-striped table-responsive" style="margin-top: 1px;">
					<thead>
						<tr>
						
							<th>No.</th>
							<th>Application date</th>
							<th>Brew Date</th>
							<th>User</th>
							<th class="td-right">Status</th>
							<th>Action</th>

						</tr>
					</thead>
					<tbody id="coffee-data">
						<tr><td colspan=6 class="success text-center" ><a href="#" class="text-bold text-italic"><i class="fa fa-spinner fa-spin"></i> loading . . . </td></tr>
					</tbody>
				 </table>
			</div>
			<div class="alert alert-success alert-dismissible fade"></div>
		</div>
	</div>
	
	<!-- Modals section -->
	<div class="modal fade" id="brewnow" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
					<h3 class="modal-title" id="lineModalLabel">Brew a coffee</h3>
				</div>
				<div class="modal-body">

					<!-- content goes here -->
					<form class="form-horizontal" id="execute_form" action="../includes/executebrew.inc.php" method="post" autocomplete="off">
					  	<input type="hidden" name="userid" value="<?php echo $_SESSION['id'];?>">

					  	<!-- Coffee level -->
						<label class="control-label" for="coffeeLevel">Coffee Level:</label><div class="clearfix"></div>
				  		<div class="btn-group" data-toggle="buttons">
				  			<label class="btn btn-bgcolor active">
				  				<input type="radio" name="coffeeLevel" value="1" id="option1" autocomplete="off" checked="checked">
				  				<span class="glyphicon glyphicon-ok" style="color:white"></span>				  			</label>
				  			<label class="btn btn-bgcolor1">
				  				<input type="radio" name="coffeeLevel" value="2" id="option2" autocomplete="off">
				  				<span class="glyphicon glyphicon-ok" style="color:white"></span>
				  			</label>
				  			<label class="btn btn-bgcolor2">
				  				<input type="radio" name="coffeeLevel" value="3" id="option3" autocomplete="off">
				  				<span class="glyphicon glyphicon-ok" style="color:white"></span>
				  			</label>

				  		</div>
						
						<div class="clearfix"></div>
						
						<!-- Creamier level -->
						<label class="control-label" for="creamerLevel">Creamer Level:</label><div class="clearfix"></div>
						<div class="btn-group" data-toggle="buttons">
							<!--  -->
							<label class="btn btn-bgcolor2">
								<input type="radio" name="creamerLevel" value="0" id="option2" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#800000"></span>
							</label>
							<label class="btn btn-bgccolor active">
								<input type="radio" name="creamerLevel" value="1" id="option2" autocomplete="off" checked="checked">
								<span class="glyphicon glyphicon-ok" style="color:#800000"></span>
							</label>
							<label class="btn btn-bgccolor1">
								<input type="radio" name="creamerLevel" value="2" id="option1" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#800000"></span>
							</label>
							<label class="btn btn-bgccolor2">
								<input type="radio" name="creamerLevel" value="3" id="option2" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#800000"></span>
							</label>
							<label class="btn btn-bgccolor3">
								<input type="radio" name="creamerLevel" value="4" id="option2" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#800000"></span>
							</label>
						</div>
						
						<div class="clearfix"></div>
						
						<!-- Sugar level -->
						<label class="control-label" for="sugarLevel">Sugar Level:</label><div class="clearfix"></div>
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-bgccolor3">
								<input type="radio" name="sugarLevel" value="0" id="option2" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#8B4513"></span>
							</label>
							<label class="btn btn-bgcccolor active">
								<input type="radio" name="sugarLevel" value="1" id="option2" autocomplete="off" checked="checked">
								<span class="glyphicon glyphicon-ok" style="color:#8B4513"></span>
							</label>
							<label class="btn btn-bgcccolor1">
								<input type="radio" name="sugarLevel" value="2" id="option1" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#8B4513"></span>
							</label>
							<label class="btn btn-bgcccolor2">
								<input type="radio" name="sugarLevel" value="3" id="option2" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#8B4513"></span>
							</label>
							<label class="btn btn-bgcccolor3">
								<input type="radio" name="sugarLevel" value="4" id="option2" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#8B4513"></span>
							</label>
						</div>
						
						<div class="clearfix"></div><div class="clearfix"></div>
						
						<div class="submit-btns">
							<!-- <button type="submit" class="btn btn-submit btn-primary btn-md btn-save">
								<i class="fa fa-save fa-fw"></i> Brew
							</button> -->
							<input type="submit" name="executebrew-submit" class="btn btn-warning btn-md btn-save" value=' Brew'>
							<button type="button" class="btn btn-default btn-close" data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="schedbrew" tabindex="-1"  aria-labelledby="modalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
					<h3 class="modal-title" id="lineModalLabel">Brew a coffee</h3>
				</div>
				<div class="modal-body">

						<!-- content goes here -->
					<form class="form-horizontal" id="submit_form" action="../includes/saveBrew.inc.php" method="post" autocomplete="off">
						 <input type="hidden" name="userid" value="<?php echo $_SESSION['id'];?>">

					  	<!-- Coffee level -->
						<label class="control-label" for="coffeeLevel">Coffee Level:</label><div class="clearfix"></div>
				  		<div class="btn-group" data-toggle="buttons">
				  			<label class="btn btn-bgcolor active">
				  				<input type="radio" name="coffeeLevel" value="1" id="option1" autocomplete="off" checked="checked">
				  				<span class="glyphicon glyphicon-ok" style="color:white"></span>
				  			</label>
				  			<label class="btn btn-bgcolor1">
				  				<input type="radio" name="coffeeLevel" value="2" id="option2" autocomplete="off">
				  				<span class="glyphicon glyphicon-ok" style="color:white"></span>
				  			</label>
				  			<label class="btn btn-bgcolor2">
				  				<input type="radio" name="coffeeLevel" value="3" id="option3" autocomplete="off">
				  				<span class="glyphicon glyphicon-ok" style="color:white"></span>
				  			</label>

				  		</div>
						
						<div class="clearfix"></div>
						
						<!-- Creamier level -->
						<label class="control-label" for="creamerLevel">Creamer Level:</label><div class="clearfix"></div>
						<div class="btn-group" data-toggle="buttons">
							<!--  -->
							<label class="btn btn-bgcolor2">
								<input type="radio" name="creamerLevel" value="0" id="option2" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#800000"></span>
							</label>
							<label class="btn btn-bgccolor active">
								<input type="radio" name="creamerLevel" value="1" id="option2" autocomplete="off" checked="checked">
								<span class="glyphicon glyphicon-ok" style="color:#800000"></span>
							</label>
							<label class="btn btn-bgccolor1">
								<input type="radio" name="creamerLevel" value="2" id="option1" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#800000"></span>
							</label>
							<label class="btn btn-bgccolor2">
								<input type="radio" name="creamerLevel" value="3" id="option2" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#800000"></span>
							</label>
							<label class="btn btn-bgccolor3">
								<input type="radio" name="creamerLevel" value="4" id="option2" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#800000"></span>
							</label>
						</div>
						
						<div class="clearfix"></div>
						
						<!-- Sugar level -->
						<label class="control-label" for="sugarLevel">Sugar Level:</label><div class="clearfix"></div>
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-bgcolor2">
								<input type="radio" name="creamerLevel" value="0" id="option2" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#800000"></span>
							</label>
							<label class="btn btn-bgcccolor active">
								<input type="radio" name="sugarLevel" value="1" id="option2" autocomplete="off" checked="checked">
								<span class="glyphicon glyphicon-ok" style="color:#8B4513"></span>
							</label>
							<label class="btn btn-bgcccolor1">
								<input type="radio" name="sugarLevel" value="2" id="option1" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#8B4513"></span>
							</label>
							<label class="btn btn-bgcccolor2">
								<input type="radio" name="sugarLevel" value="3" id="option2" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#8B4513"></span>
							</label>
							<label class="btn btn-bgcccolor3">
								<input type="radio" name="sugarLevel" value="4" id="option2" autocomplete="off">
								<span class="glyphicon glyphicon-ok" style="color:#8B4513"></span>
							</label>
						</div>
						
						<div class="clearfix"></div>

						<div class="form-group col-lg-6 col-md-6 col-sm-4 offset-lg-1 offset-md-1 offset-sm-1">
							<label class="control-label" for="brewDate">Brew date:</label>
							<div class="input-group">
								<input class="form-control pull-left" id="brewDate" name="brewDatee" />
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
							</div>
						</div>
						<div class="clearfix"></div>
						
						<div class="submit-btns">
							<!-- <button type="submit" class="btn btn-submit btn-primary btn-md btn-save">
								<i class="fa fa-save fa-fw"></i> Brew
							</button> -->
							<input type="submit" name="brew-submit" class="btn btn-warning btn-md btn-save" value=' Brew'>
							<button type="button" class="btn btn-default btn-close" data-dismiss="modal">Close</button>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="roundspaceModal" tabindex="-1"  aria-labelledby="modalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
					<h3 class="modal-title" id="lineModalLabel">My Modal</h3>
				</div>
				<div class="modal-body">
					<div class="btn-group pull-right">
						<button id="anlyt1" type="button" class="btn btn-primary btn-xs active" >1</button>
						<button id="anlyt2" type="button" class="btn btn-primary btn-xs">2</button>
						<button id="anlyt3" type="button" class="btn btn-primary btn-xs">3</button>
					</div>
					<div class="clearfix"></div>

				</div>
				<div class="modal-footer">
					hellos
				</div>
			</div>
		</div>
	</div>
	<div id="test" class="padding container-fluid"></div>
	
	<div id="coffee-temp" class="hide"></div>
	<div id="coffee-row" class="hide">
		<table>
			<tbody>
				<tr>
					<td class="no"></td>
					<td class="appDate"></td>
					<td class="brewDate"></td>
					<td class="user"></td>
					<td class="status"></td>
					<td class="text-center action">
						<a href="#" id="delete" title="Edit" data-href="" data-toggle="modal" data-target="#confirm"> <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
	   					</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<!-- confirm modal-->
<div class="modal fade" id="confirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Confirm Message</h4>
			</div>
			<div id="modal-confirm-message" class="modal-body reminder-modal">
				Click "confirm" to confirm
			</div>
			<div class="modal-footer" align="right">
				<button type="button" class="btn btn-default confirm-no" data-dismiss="modal" style="width: 20%;">Close</button>
				<a class="btn btn-primary btn-ok" style="width: 20%;">Confirm</a>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

