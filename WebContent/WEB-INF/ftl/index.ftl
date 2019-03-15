<#include "./commons/head.ftl">
<body>
  <!-- Sidenav -->
  
  <!-- Main content -->
  <div class="main-content">
    <#include "./commons/top-nav.ftl">
    <div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
  	  <div class="container-fluid">
        <div class="header-body">
          <#include "./commons/header.ftl">
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
                  <h6 class="text-uppercase ls-1 mb-1">以往的搜索记录</h6>
                  <h2 class="mb-0">系统记录的书籍</h2>
                </div>
                <div class="col">
                  <ul class="nav nav-pills justify-content-end">
                      
                  </ul>
                </div>
              </div>
            </div>
            <div class="card-body">
           	  <div class="row">
           	    <#list books as book>
	           	    <div class="col-xl-2 mb-3">
			              <div class="card shadow" style="width: 100%;">
						    <a href="${book.alt}" target="_blank"><img class="card-img-top" src="${book.image}" alt="Card image cap"></a>
							<div class="card-body">
							  <a href="${book.alt}" target="_blank"><h5 class="card-title" style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap">${book.title}</h5></a>
							  <p class="card-text" style="font-size:12px;text-overflow:ellipsis;overflow:hidden;white-space:nowrap">${book.author}</p>
							</div>
							<#if userInfo??>
								<#if !book.isFavorite><button class="btn btn-success btn-sm btn-block" style="border-radius:0px" onclick="window.location.href='${assets_path}/addfavorite/${book.id}.htm?pagen=${pagen}'">收 藏</button></#if>
								<#if book.isFavorite><button class="btn btn-success btn-sm btn-block" style="border-radius:0px" disabled>已收藏</button></#if>
							</#if>
							<#if (userInfo??&&userInfo.isAdmin == 'y')><button data-toggle="modal" data-target="#deleteModal" data-delete-url="${assets_path}/book/delete.htm?id=${book.id}" class="btn btn-warning btn-sm btn-block" style="border-radius:0px">删除此记录</button></#if>
						  </div>
		            </div>
	            </#list>
           	  </div>
           	  <#include "./commons/page.ftl">
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