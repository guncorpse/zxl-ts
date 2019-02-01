  <!-- Argon Scripts -->
  <!-- Core -->
  <script src="${assets_path}/assets/vendor/jquery/dist/jquery.min.js"></script>
  <script src="${assets_path}/assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Optional JS -->
  <script src="${assets_path}/assets/vendor/chart.js/dist/Chart.min.js"></script>
  <script src="${assets_path}/assets/vendor/chart.js/dist/Chart.extension.js"></script>
  <!-- Argon JS -->
  <script src="${assets_path}/assets/js/argon.js?v=1.0.0"></script>
  
  <script>
  	$('#searchForm').submit(function(e){
	  e.preventDefault();
	  var keyword = $('#searchInput').val();
	  if (!keyword) {
	  	$('#warning').modal('show')
	  	return false;
	  }
	  $('#loading').modal('show');
	  window.location.href = "http://localhost:8080/zxl-ts/search.htm?keyword=" + keyword;
	});
	
	$(function(){
		<#if errorMessage??>$('#errorMessage').modal('show');</#if>
		$('#deleteModal').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  var deleteUrl = button.data('delete-url') // Extract info from data-* attributes
		  var modal = $(this)
		  $('#deleteButton').attr('href', deleteUrl);
		})
	})
  </script>
  
  <div class="modal fade" id="warning" tabindex="-1" role="dialog" aria-labelledby="modal-notification" aria-hidden="true">
    <div class="modal-dialog modal-warning modal-dialog-centered modal-" role="document">
        <div class="modal-content bg-gradient-warning">
            <div class="modal-header">
                <h6 class="modal-title" id="modal-title-notification">警告</h6>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="py-3 text-center">
                    <i class="ni ni-bell-55 ni-3x"></i>
                    <h4 class="heading mt-4">请先输入图书关键字再搜索!</h4>
                    <p>可以输入任意相关信息的关键字，我们会从互联网中查询相关的所有书籍信息。</p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-link text-white ml-auto" data-dismiss="modal">知道了</button>
            </div>
        </div>
    </div>
  </div>
  
  <div class="modal fade" id="errorMessage" tabindex="-1" role="dialog" aria-labelledby="errorMessage" aria-hidden="true">
    <div class="modal-dialog modal-danger modal-dialog-centered modal-" role="document">
        <div class="modal-content bg-gradient-danger">
            <div class="modal-header">
                <h6 class="modal-title" id="modal-title-notification">错误！</h6>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="py-3 text-center">
                    <i class="ni ni-bell-55 ni-3x"></i>
                    <h4 class="heading mt-4">服务器出错了!</h4>
                    <p>${errorMessage}</p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-link text-white ml-auto" data-dismiss="modal">知道了</button>
            </div>
        </div>
    </div>
  </div>
  
  <div class="modal fade" id="loading" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="loading" aria-hidden="true">
    <div class="modal-dialog modal-success modal-dialog-centered modal-sm" role="document">
        <div class="modal-content bg-gradient-success">
            <div class="modal-body">
                <div class="py-3 text-center">
                	<div class="row">
                		<div class="col-lg-3" style="text-align:right"><i class="fa fa-spinner fa-pulse fa-2x"></i></div>
                		<div class="col-lg-9" style="text-align:left">正在从互联网搜索书籍信息...</div>
                	</div>
                </div>
            </div>
        </div>
    </div>
  </div>
  
  <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="login-modal" aria-hidden="true">
    <div class="modal-dialog modal- modal-dialog-centered modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-body p-0">
				<div class="card bg-secondary shadow border-0">
				    <div class="card-body px-lg-5 py-lg-5">
				        <div class="text-center text-muted mb-4">
				            <small>图书查询系统用户登录</small>
				        </div>
				        <form role="form" action="${assets_path}/user/login.htm" method="POST" AUTOCOMPLETE="off">
				            <div class="form-group mb-3">
				                <div class="input-group input-group-alternative">
				                    <div class="input-group-prepend">
				                        <span class="input-group-text"><i class="ni ni-single-02"></i></span>
				                    </div>
				                    <input class="form-control" placeholder="账号" name="account" id="account" type="text">
				                </div>
				            </div>
				            <div class="form-group">
				                <div class="input-group input-group-alternative">
				                    <div class="input-group-prepend">
				                        <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
				                    </div>
				                    <input class="form-control" placeholder="密码" name="password" id="password" type="password">
				                </div>
				            </div>
				            <!--
				            <div class="custom-control custom-control-alternative custom-checkbox">
				                <input class="custom-control-input" id=" customCheckLogin" type="checkbox">
				                <label class="custom-control-label" for=" customCheckLogin">
				                    <span class="text-muted">Remember me</span>
				                </label>
				            </div>
				            -->
				            <div class="text-center">
				                <button type="submit" class="btn btn-primary my-4">登 录</button>
				                <button type="button" class="btn btn-outline-secondary" onclick="window.location.href='${assets_path}/user/register.htm'">去注册</button>
				            </div>
				        </form>
				    </div>
				</div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModal" aria-hidden="true">
    <div class="modal-dialog modal-danger modal-dialog-centered modal-" role="document">
        <div class="modal-content bg-gradient-danger">
        	
            <div class="modal-header">
                <h6 class="modal-title" id="modal-title-notification">操作确认</h6>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="py-3 text-center">
                    <i class="ni ni-bell-55 ni-3x"></i>
                    <h4 class="heading mt-4">请注意!</h4>
                    <p>你确定要删除此条书籍记录吗？ 删除后不可恢复。</p>
                </div>
            </div>
            <div class="modal-footer">
                <a class="btn btn-white" id="deleteButton" style="color:#000">确认，继续删除</a>
                <button type="button" class="btn btn-link text-white ml-auto" data-dismiss="modal">取消</button> 
            </div>
        </div>
    </div>
</div>
