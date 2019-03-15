<#include "./commons/head.ftl">
<body>
  <!-- Sidenav -->
  
  <!-- Main content -->
  <div class="main-content">
    <#include "./commons/top-nav.ftl">
    <div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
  	  <div class="container-fluid">
        <div class="header-body">
        </div>
      </div>
    </div>
    <!-- Page content -->
    <div class="container-fluid mt--7">
      <div class="row">
        <div class="col-xl-12 mb-12 mb-xl-0">
          <div class="card shadow">
            <div class="card-header bg-transparent">
              <div class="row align-items-center">
                <div class="col">
                  <h6 class="text-uppercase ls-1 mb-1"></h6>
                  <#if userInfo??><h2 class="mb-0">用户管理</h2></#if>
                </div>
                <!--
                <div class="col">
                  <ul class="nav nav-pills justify-content-end">
                    <li class="nav-item mr-2 mr-md-0" >
                      <a href="#" class="nav-link py-2 px-3 active" data-toggle="tab">
                        <span class="d-none d-md-block">Month</span>
                        <span class="d-md-none">M</span>
                      </a>
                    </li>
                    <li class="nav-item" data-toggle="chart" >
                      <a href="#" class="nav-link py-2 px-3" data-toggle="tab">
                        <span class="d-none d-md-block">Week</span>
                        <span class="d-md-none">W</span>
                      </a>
                    </li>
                  </ul>
                </div>
                -->
              </div>
            </div>
            <div class="card-body">
            
           	  <div class="row">
           	  	
           	  	<#if users?size lt 1>
           	  		<div class="col-xl-6 offset-3">
	           	  		<div class="alert alert-warning" role="alert" style="100%">
						    <strong>没有用户！</strong>
						</div>
           	  		</div>
           	  	<#else>
		           	    <!-- Table -->
					      <div class="row" style="width:100%;margin:0px">
					        <div class="col">
					          <!--<button class="btn btn-success">新增</button>-->
					          <div class="card shadow" >
					            <div class="table-responsive" >
					              <table class="table align-items-center table-flush" >
					                <thead class="thead-light">
					                  <tr>
					                    <th scope="col">昵称</th>
					                    <th scope="col">账号</th>
					                    <th scope="col">是否管理员</th>
					                    <th scope="col">操作</th>
					                  </tr>
					                </thead>
					                <tbody>
					                <#list users as user>
					                  <tr>
					                    <th scope="row">
					                      <div class="media align-items-center">
					                        <div class="media-body">
					                          <span class="mb-0 text-sm">${user.name}</span>
					                        </div>
					                      </div>
					                    </th>
					                    <td>
					                      <span class="badge badge-dot mr-4">
					                        ${user.account}
					                      </span>
					                    </td>
					                    <td>
					                      <span class="badge badge-dot mr-4">
					                        <#if user.isAdmin == 'y'><i class="bg-success"></i> 是</#if>
					                        <#if user.isAdmin == 'n'><i class="bg-warning"></i> 否</#if>
					                      </span>
					                    </td>
					                    <td>
					                        <button class="btn btn-primary" onclick="window.location.href='${assets_path}/user/update.htm?id=${user.id}'">更改类型</button>
					                        <button class="btn btn-danger" data-toggle="modal" data-target="#deleteModal" data-delete-url="${assets_path}/user/delete.htm?id=${user.id}">删除此用户</button>
					                    </td>
					                  </tr>
					                  </#list>
					                </tbody>
					              </table>
					            </div>
					            <div class="card-footer py-4">
					            </div>
					          </div>
					        </div>
					      </div>
		         </#if>
           	  </div>
            </div>
          </div>
        </div>
      </div>
	  <#include "./commons/footer.ftl">
    </div>
  </div>
  <#include "./commons/body-script.ftl">
</body>

</html>