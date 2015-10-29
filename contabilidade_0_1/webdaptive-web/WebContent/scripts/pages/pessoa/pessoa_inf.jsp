<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>

<div class="container-fluid">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading"></div>
			<div class="panel-body" style="margin-left: 30px;">
				<div class="col-md-3">
						<div class="form-group">

							<label for="inputEmail3" class="col-sm-2 control-label">
								Codigo
							</label>
							<div class="col-sm-10">
								<input type="" class="form-control" id="codigo" />
							</div>
						</div>
				</div>
				<div class="col-md-3">
						<div class="form-group">

							<label for="inputEmail3" class="col-sm-2 control-label">
								Pessoa
							</label>
							<div class="col-sm-10">
								<select id="mySel" name="regime" class="regime" style="width: 80%;">
									<option value="1"> Fisica</option>
									<option value="2"> Juridica</option>
								</select>
							</div>
						</div>
				</div>
				<div class="col-md-4">
						<div class="form-group">

							<label for="inputEmail3" class="col-sm-2 control-label">
								Nome
							</label>
							<div class="col-sm-10">
								<input type="" class="form-control" id="cdbarra" />
							</div>
						</div>
				</div>

				<div class="col-md-2">
						<div class="form-group">

							<label for="inputEmail3" class="col-sm-2 control-label">
								Data
							</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputEmail3" />
							</div>
						</div>
				</div>
			</div>
		</div>
	</div>
</div>