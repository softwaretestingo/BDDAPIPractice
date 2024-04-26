Feature: Validating Place API

Scenario: Verify is place is being added using Add Place API
		Given Add place payload
		When user call the "AddPlace" API with the HTTP Post request
		Then The API call will receive Status Code 200
		And status in response body is OK