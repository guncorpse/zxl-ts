<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Start your development with a Dashboard for Bootstrap 4.">
  <meta name="author" content="Creative Tim">
  <title>图书信息查询系统注册——张霄林的毕业设计</title>
  <!-- Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
  <!-- Icons -->
  <link href="${assets_path}/assets/vendor/nucleo/css/nucleo.css" rel="stylesheet">
  <link href="${assets_path}/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet">
  <!-- Argon CSS -->
  <link type="text/css" href="${assets_path}/assets/css/argon.css?v=1.0.0" rel="stylesheet">
</head>

<body class="bg-default">
  <div class="main-content">
    <!-- Navbar -->
    <nav class="navbar navbar-top navbar-horizontal navbar-expand-md navbar-dark">
      <div class="container px-4">
        <a class="h2 mb-0 text-white text-uppercase d-none d-lg-inline-block"" href="${assets_path}/index.htm">
          图书信息查询系统
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse-main" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar-collapse-main">
          <!-- Collapse header -->
          <div class="navbar-collapse-header d-md-none">
            <div class="row">
              <div class="col-6 collapse-brand">
                <a href="${assets_path}/index.html">
                  书籍信息查询系统
                </a>
              </div>
              <div class="col-6 collapse-close">
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle sidenav">
                  <span></span>
                  <span></span>
                </button>
              </div>
            </div>
          </div>
          <!-- Navbar items -->
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link nav-link-icon" href="${assets_path}/index.htm">
                <i class="ni ni-planet"></i>
                <span class="nav-link-inner--text">主页</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- Header -->
    <div class="header bg-gradient-primary py-7 py-lg-8">
      <div class="container">
        <div class="header-body text-center mb-7">
          <div class="row justify-content-center">
            <div class="col-lg-5 col-md-6">
              <h1 class="text-white">欢迎注册！</h1>
              <p class="text-lead text-light">注册之后，你就可以通过关键字从互联网查询，还可以将喜欢的书籍添加到收藏夹中。</p>
            </div>
          </div>
        </div>
      </div>
      <div class="separator separator-bottom separator-skew zindex-100">
        <svg x="0" y="0" viewBox="0 0 2560 100" preserveAspectRatio="none" version="1.1" xmlns="http://www.w3.org/2000/svg">
          <polygon class="fill-default" points="2560 0 2560 100 0 100"></polygon>
        </svg>
      </div>
    </div>
    <!-- Page content -->
    <div class="container mt--8 pb-5">
      <!-- Table -->
      <div class="row justify-content-center">
        <div class="col-lg-6 col-md-8">
          <div class="card bg-secondary shadow border-0">
            <div class="card-body px-lg-5 py-lg-5">
              <form role="form" action="${assets_path}/user/register.htm" method="POST" id="registerForm">
                <div class="form-group">
                  <div class="input-group input-group-alternative mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="ni ni-hat-3"></i></span>
                    </div>
                    <input class="form-control" placeholder="名称" name="name" id="name" type="text">
                  </div>
                </div>
                <div class="form-group">
                  <div class="input-group input-group-alternative mb-3">
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
                    <input class="form-control" placeholder="Password" name="password" id="password" type="password">
                  </div>
                </div>
                <!--<div class="text-muted font-italic"><small>密码强度: <span class="text-success font-weight-700">强</span></small></div>-->
                <div class="row my-4">
                  <div class="col-12">
                    <div class="custom-control custom-control-alternative custom-checkbox">
                      <input class="custom-control-input" id="customCheckRegister" type="checkbox">
                      <label class="custom-control-label" for="customCheckRegister">
                        <span class="text-muted">我同意 <a href="#!">《图书信息查询系统用户守则》</a></span>
                      </label>
                    </div>
                  </div>
                </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-primary mt-4">创建账号</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Footer -->
  <footer class="py-5">
    <div class="container">
      <div class="row align-items-center justify-content-xl-between">
        <div class="col-xl-6">
          <div class="copyright text-center text-xl-left text-muted">
            &copy; 2019 ZhangXiaoLin
          </div>
        </div>
      </div>
    </div>
  </footer>
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
                    <h4 class="heading mt-4">请填写必填项哦!</h4>
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
  <div class="modal fade" id="success" tabindex="-1" role="dialog" aria-labelledby="success" aria-hidden="true">
    <div class="modal-dialog modal-success modal-dialog-centered modal-sm" role="document">
        <div class="modal-content bg-gradient-success">
            <div class="modal-body">
                <div class="py-3 text-center">
                	创建成功！
                </div>
            </div>
        </div>
    </div>
  </div>
  <!-- Argon Scripts -->
  <!-- Core -->
  <script src="${assets_path}/assets/vendor/jquery/dist/jquery.min.js"></script>
  <script src="${assets_path}/assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Argon JS -->
  <script src="${assets_path}/assets/js/argon.js?v=1.0.0"></script>
  <script>
  	$('#registerForm').submit(function(e){
  		var name = $('#name').val();
  		var account = $('#account').val();
  		var password = $('#password').val();
  		if (!name || !account || !password){
  			$('#warning').modal('show');
  			return false;
  		}
  	})
  	$(function(){
  		<#if errorMessage?? >
  			$('#errorMessage').modal('show');
  		</#if>
  		<#if success?? >
  			$('#success').modal('show');
  		</#if>
  	})
  </script>
</body>

</html>