<button data-toggle="modal" data-target="#create-service-request-modal" class="btn btn-success floating-button-right">+</button>
<input type="hidden" id="show-create-service-request-modal" value="${showCreateServiceRequestModal!""}"/>
<!-- Modal -->
<div class="modal fade" id="create-service-request-modal" role="dialog">
  <div class="modal-dialog modal-lg">
      <form class="form-horizontal" action="/user/service-requests" method="POST" id="serviceRequestCreateForm" name="serviceRequestCreateForm">
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <div class="modal-title text-center">
                      <h3><span class="label label-default">Create User</span></h3>
                  </div>
              </div>
              <div class="modal-body">
                  <div class="container-fluid main-container">
                      <div class="row">
                          <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                              <fieldset>
                                  <div class="form-group">
                                      <label for="username">Username</label>
                                  <#--<@spring.bind "userCreateForm.username"/>-->
                                      <input type="text" class="form-control" id="username" name="username" placeholder="johnDoe" <#--value="${userCreateForm.username!""}"--> required/>

                                  </div>
                                  <div class="form-group">
                                      <label for="password">Password</label>
                                  <#--<@spring.bind "userCreateForm.password"/>-->
                                      <input type="password" class="form-control" id="password" name="password" placeholder="p4$$w0rd" required/>

                                  </div>
                                  <div class="form-group">
                                      <label for="firstName">First Name</label>
                                  <#--<@spring.bind "userCreateForm.firstName"/>-->
                                      <input type="text" class="form-control" id="firstName" name="firstName" placeholder="John" <#--value="${userCreateForm.firstName!""}"--> required/>

                                  </div>
                                  <div class="form-group">
                                      <label for="lastName">LastName</label>
                                  <#--<@spring.bind "userCreateForm.lastName"/>-->
                                      <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Doe" <#--value="${userCreateForm.lastName!""}"--> required/>

                                  </div>
                                  <div class="form-group">
                                      <label for="type">Type</label>
                                  <#--<@spring.bind "userCreateForm.role"/>-->
                                      <select class="form-control" id="type" name="role" <#--current-selected="${userCreateForm.role!"NONE"}"-->>
                                          <option value="USER">User</option>
                                          <option value="ADMIN">Admin</option>
                                      </select>

                                  </div>
                                  <div class="form-group">
                                      <label for="email">Email</label>
                                  <#--<@spring.bind "userCreateForm.email"/>-->
                                      <input type="email" class="form-control" id="email" name="email" placeholder="john@doe.com" <#--value="${userCreateForm.email!""}-->" required/>

                                  </div>
                              </fieldset>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="modal-footer">
                  <button type="submit" id="btn-submit" class="btn btn-success mr-auto">Submit</button>
                  <button type="reset" id="btn-clear" class="btn btn-danger btn-md mr-auto">Clear</button>
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
          </div>
      </form>
  </div>
</div>