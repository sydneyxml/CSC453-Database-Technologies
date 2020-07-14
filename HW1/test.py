import csv

with open('Loan.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            print(f'Column names are {", ".join(row)}')
            line_count += 1
        else:

            print(f"insert into Loan values ( {row[0]}, '{row[1]}', '{row[2]}', {row[3]}, {row[4]}, {row[5]}, '{row[6]}', {row[7]}, {row[8]} );")
            # print(f"\t insert into Loan values ( {row[0]}, '{row[1]}', '{row[2]}', {row[3]}, {row[4]}, {row[5]}, '{row[6]}', {row[7]}, {row[8]} );")
            
            # print(f"\t{row[0]}, '{row[1]}', '{row[2]}', {row[3]}, {row[4]}, {row[5]}, '{row[6]}', {row[7]}, {row[8]}")
            
            line_count += 1
    print(f'Done')
