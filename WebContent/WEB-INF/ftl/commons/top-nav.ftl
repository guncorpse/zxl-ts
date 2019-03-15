<!-- Top navbar -->
<nav class="navbar navbar-top navbar-expand-md navbar-dark" id="navbar-main">
  <div class="container-fluid">
    <!-- Brand -->
    <a class="h1 mb-0 text-white text-uppercase d-none d-lg-inline-block" href="${assets_path}/index.htm">图书信息查询系统</a>
    <!-- Form -->
    <form class="navbar-search navbar-search-dark form-inline mr-3 d-none d-md-flex ml-lg-auto" id="searchForm" autocomplete="off">
      <div class="form-group mb-0">
        <div class="input-group input-group-alternative">
          <div class="input-group-prepend">
            <span class="input-group-text"><i class="fas fa-search"></i></span>
          </div>
          <input class="form-control" placeholder="搜索图书" value="${keyword}" id="searchInput" type="text">
        </div>
      </div>
    </form>
    <!-- User -->
    <ul class="navbar-nav align-items-center d-none d-md-flex">
    
    <#if userInfo ??>
      <li class="nav-item dropdown">
        <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <div class="media align-items-center">
            <!--<span class="avatar avatar-sm rounded-circle">
              <img alt="Image placeholder" src="${assets_path}/assets/img/theme/team-4-800x800.jpg">
            </span>-->
            <div class="media-body ml-2 d-none d-lg-block">
              <span class="mb-0 text-sm  font-weight-bold">用户：${userInfo.name}</span>
            </div>
          </div>
        </a>
        <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
          <div class=" dropdown-header noti-title">
            <h6 class="text-overflow m-0">欢迎您！</h6>
          </div>
          <a href="${assets_path}/favorite/${userInfo.id}.htm" class="dropdown-item">
            <i class="ni ni-book-bookmark"></i>
            <span>我的收藏夹</span>
          </a>
          <#if (userInfo?? && userInfo.isAdmin == 'y')>
          <a href="${assets_path}/user.htm" class="dropdown-item">
            <i class="ni ni-single-02"></i>
            <span>用户管理</span>
          </a>
          </#if>
          <!--
          <a href="./examples/profile.html" class="dropdown-item">
            <i class="ni ni-settings-gear-65"></i>
            <span>Settings</span>
          </a>
          <a href="./examples/profile.html" class="dropdown-item">
            <i class="ni ni-calendar-grid-58"></i>
            <span>Activity</span>
          </a>
          <a href="./examples/profile.html" class="dropdown-item">
            <i class="ni ni-support-16"></i>
            <span>Support</span>
          </a>
          -->
          <div class="dropdown-divider"></div>
          <a href="${assets_path}/user/logout.htm" class="dropdown-item">
            <i class="ni ni-user-run"></i>
            <span>注销登录</span>
          </a>
        </div>
      </li>
    <#else>
      <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#login-modal">点击登录</button>
    </#if>
    </ul>
  </div>
</nav>