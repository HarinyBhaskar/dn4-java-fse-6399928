-- Exercise 2: Stored Procedures
-- Submitted by Hariny Bhaskar (6399928)

-----------------------------------------------------------
-- Scenario 1: ProcessMonthlyInterest (1% for all savings)
-----------------------------------------------------------

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR acc IN (SELECT * FROM SavingsAccount) LOOP
    UPDATE SavingsAccount
    SET balance = balance + (balance * 0.01)
    WHERE accountid = acc.accountid;
  END LOOP;
  COMMIT;
END;
/

-----------------------------------------------------------
-- Scenario 2: UpdateEmployeeBonus (Add bonus to salaries)
-----------------------------------------------------------

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  dept_id IN NUMBER,
  bonus_percent IN NUMBER
) IS
BEGIN
  UPDATE Employee
  SET salary = salary + (salary * bonus_percent / 100)
  WHERE department_id = dept_id;

  COMMIT;
END;
/

-----------------------------------------------------------
-- Scenario 3: TransferFunds (Move amount from one account to another)
-----------------------------------------------------------

CREATE OR REPLACE PROCEDURE TransferFunds (
  from_account IN NUMBER,
  to_account IN NUMBER,
  amount IN NUMBER
) IS
  from_balance NUMBER;
BEGIN
  SELECT balance INTO from_balance
  FROM Account
  WHERE accountid = from_account;

  IF from_balance >= amount THEN
    UPDATE Account
    SET balance = balance - amount
    WHERE accountid = from_account;

    UPDATE Account
    SET balance = balance + amount
    WHERE accountid = to_account;

    COMMIT;
  ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient funds in the source account.');
  END IF;

EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('One of the accounts does not exist.');
END;
/
