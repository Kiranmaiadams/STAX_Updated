Feature: User Verifies the Sort Order Functionality


Scenario Outline: User Verifies if the ort order is displayed properly <Sort Option>

Given User selects the <Sort Option>
#Then Verify the Results for <Sort Option>

Examples:

|Sort Option|
|Price (Low-High)|
|Price (High-Low)|
|Price/Day(Low-High)|
|Price/Day(High-Low)|
|Duration(Lowest)|