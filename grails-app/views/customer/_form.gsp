<%@ page import="com.rickshaw.Customer" %>



<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="customer.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${customerInstance?.firstName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="customer.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${customerInstance?.lastName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="customer.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${customerInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="customer.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" maxlength="8" required="" value="${customerInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'orders', 'error')} ">
	<label for="orders">
		<g:message code="customer.orders.label" default="Orders" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${customerInstance?.orders?}" var="o">
    <li><g:link controller="order" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="order" action="create" params="['customer.id': customerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'order.label', default: 'Order')])}</g:link>
</li>
</ul>


</div>

