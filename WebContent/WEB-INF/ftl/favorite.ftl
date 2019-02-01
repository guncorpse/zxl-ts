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
                  <h6 class="text-uppercase ls-1 mb-1">你自己收藏的喜欢书籍</h6>
                  <#if userInfo??><h2 class="mb-0">${userInfo.name}的收藏夹</h2></#if>
                </div>
                <!--
                <div class="col">
                  <ul class="nav nav-pills justify-content-end">
                    <li class="nav-item mr-2 mr-md-0" data-toggle="chart" data-target="#chart-sales" data-update='{"data":{"datasets":[{"data":[0, 20, 10, 30, 15, 40, 20, 60, 60]}]}}' data-prefix="$" data-suffix="k">
                      <a href="#" class="nav-link py-2 px-3 active" data-toggle="tab">
                        <span class="d-none d-md-block">Month</span>
                        <span class="d-md-none">M</span>
                      </a>
                    </li>
                    <li class="nav-item" data-toggle="chart" data-target="#chart-sales" data-update='{"data":{"datasets":[{"data":[0, 20, 5, 25, 10, 30, 15, 40, 40]}]}}' data-prefix="$" data-suffix="k">
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
           	  	
           	  	<#if favorites?size lt 1>
           	  		<div class="col-xl-6 offset-3">
	           	  		<div class="alert alert-warning" role="alert" style="100%">
						    <strong>你还没有收藏书籍，</strong> 快去搜索收藏吧。
						</div>
           	  		</div>
           	  	<#else>
	           	  	<#list favorites as book>
		           	    <div class="col-xl-2 mb-3">
			           	    <a href="${book.alt}" target="_blank">
				              <div class="card shadow" style="width: 100%;">
							    <img class="card-img-top" style="height:230px;" src="${book.image}" alt="Card image cap">
								<div class="card-body">
								  <h5 class="card-title" style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap">${book.title}</h5>
								  <p class="card-text" style="font-size:12px;text-overflow:ellipsis;overflow:hidden;white-space:nowrap">${book.author}</p>
								</div>
							  </div>
							</a>
			            </div>
		            </#list>
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