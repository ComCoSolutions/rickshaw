<%@ page import="com.rickshaw.Order" %>



<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'total', 'error')} required">
	<label for="total">
		<g:message code="order.total.label" default="Total" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="total" value="${fieldValue(bean: orderInstance, field: 'total')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'customer', 'error')} required">
	<label for="customer">
		<g:message code="order.customer.label" default="Customer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="customer" name="customer.id" from="${com.rickshaw.Customer.list()}" optionKey="id" required="" value="${orderInstance?.customer?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'orderItems', 'error')} ">
	<label for="orderItems">
		<g:message code="order.orderItems.label" default="Order Items" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${orderInstance?.orderItems?}" var="o">
    <li><g:link controller="orderItem" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="orderItem" action="create" params="['order.id': orderInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'orderItem.label', default: 'OrderItem')])}</g:link>
</li>
</ul>


</div>

